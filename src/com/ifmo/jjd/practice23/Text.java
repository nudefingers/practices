package com.ifmo.jjd.practice23;


import com.ifmo.jjd.practice23.annotations.Component;

@Component(fileName = "text.txt")
public class Text extends Message{

    public String text;

    public Text(String sender) {
        super(sender);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
