import com.arsiu.model.manager.SessionManager;
import com.arsiu.view.View;

public class Main {

    public static void main(final String[] args) throws Exception {
        SessionManager.openSession();
        new View();
        SessionManager.closeSession();
    }
}