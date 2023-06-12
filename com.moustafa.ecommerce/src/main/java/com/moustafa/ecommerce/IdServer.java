package com.moustafa.ecommerce;


public class IdServer{

    protected int idCounter;
    protected String prefix;

    protected QueueStack queue;

    public IdServer (String prefix){
        idCounter = 1;
        this.prefix = prefix;
        queue = new QueueStack();
    }

    public int getId(){
        if(getQueueSize() == 0){
            return idCounter++;
        }
        return queue.dequeue();
    }

    public int getQueueSize(){
        return queue.getSize();
    }

    public void removeId(String id){
        int removedId = getIntFromId(id);
        queue.enqueue(removedId);
    }

    public int getIntFromId(String id){
        char charId = id.charAt(1);
        return Character.getNumericValue(charId);
    }

    public String createId(){
        String stringId = prefix + getId();
        return stringId;
    }

}
