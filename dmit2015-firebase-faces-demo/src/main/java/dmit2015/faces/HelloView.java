package dmit2015.faces;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;
import org.omnifaces.util.Messages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named // Register this class as CDI managed object name helloView
@ViewScoped // @RequestScoped, @ViewScoped, @SessionScoped, @ApplicationScoped
public class HelloView implements Serializable {

    @NotBlank(message = "username is required.")
    private String username;

    private List<String> userList = new ArrayList();

    public List<String> getUserList() {
        return userList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void onSayHello() {
        Messages.addGlobalInfo("Hello {0} to JakartaFaces", username);
        Messages.addGlobalError("Hello {0} to JakartaFaces", username);
    }

    public void onAddUser() {
        userList.add(username);
        username = null;
    }

    public void onClear() {
        username = null;
    }
}
