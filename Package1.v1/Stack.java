package Package1;

public interface Stack {

		boolean empty () ;
		
		void push ( Value value ) ;
		
	  Value pop () throws EmptyStackException ;
		
		 Value peek () throws EmptyStackException ;
		 }


