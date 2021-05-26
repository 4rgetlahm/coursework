package net.Arnas.planes;

public class NoEngineException extends RuntimeException{
    @Override
    public String getMessage(){
        return "No engine found";
    }
}
