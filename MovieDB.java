import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Genre, Title 을 관리하는 영화 데이터베이스.
 * 
 * MyLinkedList 를 사용해 각각 Genre와 Title에 따라 내부적으로 정렬된 상태를  
 * 유지하는 데이터베이스이다. 
 */
public class MovieDB {
    
	private MyLinkedList<Genre> genreList;
	
	public MovieDB() {
        // FIXME implement this
    	// HINT: MovieDBGenre 클래스를 정렬된 상태로 유지하기 위한 
    	// MyLinkedList 타입의 멤버 변수를 초기화 한다.
    	
    	genreList = new MyLinkedList<>();
    }

    public void insert(MovieDBItem item) {
        // FIXME implement this
        // Insert the given item to the MovieDB.

    	// Printing functionality is provided for the sake of debugging.
        // This code should be removed before submitting your work.
        System.err.printf("[trace] MovieDB: INSERT [%s] [%s]\n", item.getGenre(), item.getTitle());
    }

    public void delete(MovieDBItem item) {
        // FIXME implement this
        // Remove the given item from the MovieDB.
    	
    	// Printing functionality is provided for the sake of debugging.
        // This code should be removed before submitting your work.
        System.err.printf("[trace] MovieDB: DELETE [%s] [%s]\n", item.getGenre(), item.getTitle());
    }

    public MyLinkedList<MovieDBItem> search(String term) {
    	// 해당되는 term을 가지고 있는 MovieDBItem list를 새로 만들어서 그걸 반환
    	// FIXME implement this
        // Search the given term from the MovieDB.
        // You should return a linked list of MovieDBItem.
        // The search command is handled at SearchCmd class.
    	
    	// Printing search results is the responsibility of SearchCmd class. 
    	// So you must not use System.out in this method to achieve specs of the assignment.
    	
        // This tracing functionality is provided for the sake of debugging.
        // This code should be removed before submitting your work.
    	System.err.printf("[trace] MovieDB: SEARCH [%s]\n", term);
    	
    	// FIXME remove this code and return an appropriate MyLinkedList<MovieDBItem> instance.
    	// This code is supplied for avoiding compilation error.   
        MyLinkedList<MovieDBItem> results = new MyLinkedList<MovieDBItem>();

        return results;
    }
    
    public MyLinkedList<MovieDBItem> items() {
        // Genre, Title로 정렬되어있는 단일 linked list를 return
    	
    	// FIXME implement this

        // The print command is handled at PrintCmd class.

    	// Printing movie items is the responsibility of PrintCmd class. 
    	// So you must not use System.out in this method to achieve specs of the assignment.

    	// Printing functionality is provided for the sake of debugging.
        // This code should be removed before submitting your work.
        System.err.printf("[trace] MovieDB: ITEMS\n");

    	// FIXME remove this code and return an appropriate MyLinkedList<MovieDBItem> instance.
    	// This code is supplied for avoiding compilation error.   
        MyLinkedList<MovieDBItem> results = new MyLinkedList<MovieDBItem>();
        
    	return results;
    }
}

class Genre extends Node<String> implements Comparable<Genre> {
	
	private MyLinkedList<MovieDBItem> movieList;
	
	public Genre(String name) {
		super(name);
		movieList = new MyLinkedList<>();
		
		//throw new UnsupportedOperationException("not implemented yet");
	}
	
	public String getName(){
		return this.getItem();
	}
	
	public MyLinkedList<MovieDBItem> getMovieList(){
		return movieList;
	}
	
	@Override
	public int compareTo(Genre o) {
		
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public int hashCode() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        Genre other = (Genre) obj;
        if (this.getItem() == null) {
            if (other.getItem() != null)
                return false;
        } 
        else if (!this.getItem().equals(other.getItem()))
            return false;
        
        // FIXME
        if (movieList == null) {
            if (other.getMovieList() != null)
                return false;
        } 
        else if (!movieList.equals(other.getMovieList()))
            return false;
        return true;
		
		
		//throw new UnsupportedOperationException("not implemented yet");
	}
}

/*
class MovieList implements ListInterface<String> {	
	public MovieList() {
		
	}

	@Override
	public Iterator<String> iterator() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public void add(String item) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public String first() {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public void removeAll() {
		throw new UnsupportedOperationException("not implemented yet");
	}
}

*/