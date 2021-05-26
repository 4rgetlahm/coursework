class Note{
    private String text;

    public Note(String text) throws NoTextException{
        this.text = text;
        if(text == null || text.equals("")){
            throw new NoTextException(this);
        }
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }
}


class NoTextException extends NoteException {

    public NoTextException(Note note) {
        super(note);
    }

    public void changeText(String text){
        super.getNote().setText(text);
    }
}

class NoteException extends Exception{
    private Note note;

    public NoteException(Note note){
        this.note = note;
    }

    public Note getNote(){
        return this.note;
    }
}



public class Main {

    public static void main(String args[]){
        try{
            Note note = new Note(null);
        } catch (NoTextException exception){
            exception.changeText("Fixed");
            System.out.println("fixed");
        }
    }
}
