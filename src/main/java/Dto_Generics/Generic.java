package Dto_Generics;

public class Generic<T>{
    
    private T _content;

    public Generic(T _content) {
        this._content = _content;
    }

    public T getContent() {
        return _content;
    }

    public void setContent(T _content) {
        this._content = _content;
    }
    
    
}