package Package1;

import java.util.ArrayList;

public class Value implements Stack {
 private final String name ;
 private final int value ;
ArrayList <Value> pile=new ArrayList <>();
 public Value ( String name , int value ) {
 this . name = name ;
 this . value = value ;
}
@Override
public String toString () {
 return "<" + this . name + ";" + this . value + ">";
 }
public boolean empty() {
	return pile.isEmpty();
}
public void push(Value value) {
pile.add(value);
}
public Value pop() throws EmptyStackException{
	try{
	
	return  pile.remove(pile.size()-1);
}  catch (Exception exception) {
    throw new EmptyStackException("la pile est vide");
}}


public Value peek () throws EmptyStackException {
	try {
		return pile.get(pile.size()-1);
		
	} catch (Exception exception) {
	    throw new EmptyStackException("la pile est vide");
	}
	
}





public static void main(String[] args) {
	
	
	
}


}

