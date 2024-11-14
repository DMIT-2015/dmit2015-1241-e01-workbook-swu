package dmit2015.restclient;

import dmit2015.restclient.TodoApiResponse;
import dmit2015.restclient.TodoApiResponseMpRestClient;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.core.Response;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.List;

@Named("currentTodoApiResponseCrudView")
@ViewScoped
public class TodoApiResponseCrudView implements Serializable {

    @Inject
    private LoginSession _loginSession;

    @Inject
    @RestClient
    private TodoApiResponseMpRestClient _todoApiResponseMpRestClient;

    @Getter
    private List<TodoApiResponse> todoApiResponseList;

    @Getter
    @Setter
    private TodoApiResponse selectedTodoApiResponse;

    @Getter
    @Setter
    private Long editId;

    @PostConstruct  // After @Inject is complete
    public void init() {
        try {
            String bearerAuth = _loginSession.getAuthorization();
            todoApiResponseList = _todoApiResponseMpRestClient.findAll(bearerAuth);
        } catch (Exception ex) {
            Messages.addGlobalError(ex.getMessage());
        }
    }

    public void onOpenNew() {
        selectedTodoApiResponse = new TodoApiResponse();
        editId = null;
    }

    public void onSave() {
        String bearerAuth = _loginSession.getAuthorization();
        if (editId == null) {
            try {
                Response response = _todoApiResponseMpRestClient.create(selectedTodoApiResponse, bearerAuth);
                String location = response.getHeaderString("Location");
                String idValue = location.substring(location.lastIndexOf("/") + 1);
                Messages.addFlashGlobalInfo("Create was successful. {0}", idValue);
                todoApiResponseList = _todoApiResponseMpRestClient.findAll(bearerAuth);
            } catch (Exception e) {
                e.printStackTrace();
                Messages.addGlobalError("Create was not successful. {0}", e.getMessage());
            }
        } else {
            try {
                _todoApiResponseMpRestClient.update(editId, selectedTodoApiResponse, bearerAuth);
                Messages.addFlashGlobalInfo("Update was successful.");
            } catch (Exception e) {
                e.printStackTrace();
                Messages.addGlobalError("Update was not successful.");
            }
        }

        PrimeFaces.current().executeScript("PF('manageTodoApiResponseDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-TodoApiResponses");
    }

    public void onDelete() {
        try {
            String bearerAuth = _loginSession.getAuthorization();
            _todoApiResponseMpRestClient.delete(editId, bearerAuth);
            editId = null;
            selectedTodoApiResponse = null;
            Messages.addGlobalInfo("Delete was successful.");
            todoApiResponseList = _todoApiResponseMpRestClient.findAll(bearerAuth);
            PrimeFaces.current().ajax().update("form:messages", "form:dt-TodoApiResponses");
        } catch (Exception e) {
            e.printStackTrace();
            Messages.addGlobalError("Delete not successful.");
        }
    }

}