public class Controller {
    private View view;

    public Controller() {
        view = new View();
        // todo: listeners and stuff for todo buttons :^)
    }

    public void sortImage(String name) {
        if(this.view != null) {
            view.setImage(name);
        }
    }
}
