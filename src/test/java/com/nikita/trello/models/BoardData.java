package com.nikita.trello.models;

public class BoardData {
    private String boardName;

    public BoardData setBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }
}
