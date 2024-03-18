package org.example;

public class Fork {

    volatile boolean inUse = false;
    private String forkName;

    public Fork(String forkName) {
        this.forkName = forkName;
    }

    public String getForkName() {
        return forkName;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
