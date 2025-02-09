package card;

public class SimpleGameCard implements Card {

    int id = -1;

    public SimpleGameCard(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
