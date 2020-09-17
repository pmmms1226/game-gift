package game;

public class Used extends AbstractEvent{
    private Long id;

    public Used(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
