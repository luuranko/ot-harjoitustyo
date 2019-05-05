package maailmanluontisovellus.domain;

public class FileLogic {
    private Logic logic;
    private FileHandler handler;
    
    /**
     * FileLogic is used to connect the data between FileHandler and Logic.
     * @param logic The Logic used by the app.
     * @param handler The FileHandler used by the app.
     */
    public FileLogic(Logic logic, FileHandler handler) {
        this.logic = logic;
        this.handler = handler;
    }
    
    /**
     * Handles moving the data from the files to the Logic during startup.
     * @throws Exception 
     */
    public void start() throws Exception {
        handler.init();
        logic.setUserlist(handler.getUserlist());
        for (User user: logic.getUserlist()) {
            user.setCharas(handler.getCharas(user));
            user.setSettles(handler.getSettles(user));
        }
        
    }
    
    /**
     * Handles moving the data from the Logic to the FileHandler
     * which writes it to the files when the app is closed.
     * @throws Exception 
     */
    public void stop() throws Exception {
        handler.setUserlist(logic.getUserlist());
        for (User user: logic.getUserlist()) {
            handler.setCharalist(user, user.getCharas());
            handler.setSettlelist(user, user.getSettles());
        }
        handler.saveUsers();
        handler.saveCharas();
        handler.saveSettles();
    }
}
