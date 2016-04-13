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
    	genreList = new MyLinkedList<>();
    }

    public void insert(MovieDBItem item) {
        // Insert the given item to the MovieDB.
    	boolean existingGenreFlag = false;
    	
    	for (Genre genre : genreList)
    	{
    		if (genre.getItem().equals(item.getGenre())) // name of the genre (String)
    		{
    			genre.addMovie(item);
    			existingGenreFlag = true;
    			break;
    		}
    	}
    	
    	if (!existingGenreFlag)
    	{
    		Genre newGenre = new Genre(item.getGenre());
    		newGenre.addMovie(item);
    		genreList.sortedAdd(newGenre);
    	}
    }

    public void delete(MovieDBItem item) {
        // Remove the given item from the MovieDB.
    	
    	for (Genre genre : genreList)
    	{
    		if (genre.getItem().equals(item.getGenre()))
    		{
    			genre.deleteMovie(item);
    			
    			if (genre.getMovieList().isEmpty())
    				genreList.remove(genre);
    			
    			break;
    		}
    	}
    }

    public MyLinkedList<MovieDBItem> search(String term) {
        // Search the given term from the MovieDB.
        // You should return a linked list of MovieDBItem.
        // The search command is handled at SearchCmd class.
    	// Printing search results is the responsibility of SearchCmd class. 
    	
    	 MyLinkedList<MovieDBItem> results = new MyLinkedList<MovieDBItem>();
    	 
    	 for (Genre genre : genreList)
    	 {
    		 for (MovieDBItem item : genre.getMovieList())
    		 {
    			 if (item.getTitle().contains(term))
    				 results.add(item);
    		 }
    	 }
    	
        return results;
    }
    
    public MyLinkedList<MovieDBItem> items() {
        // Genre, Title로 정렬되어있는 단일 linked list를 return
        // The print command is handled at PrintCmd class.
    	// Printing movie items is the responsibility of PrintCmd class. 
    	
    	MyLinkedList<MovieDBItem> results = new MyLinkedList<MovieDBItem>();
    	for (Genre genre : genreList)
    	{
    		for (MovieDBItem item : genre.getMovieList())
    		{
    			results.add(item);
    		}
    	}

    	return results;
    }
}

class Genre extends Node<String> implements Comparable<Genre> {
	
	private MyLinkedList<MovieDBItem> movieList;
	
	public Genre(String name) {
		super(name);
		movieList = new MyLinkedList<>();
	}
	
	public MyLinkedList<MovieDBItem> getMovieList(){
		return movieList;
	}
	
	public void addMovie(MovieDBItem item)
	{
		movieList.sortedAdd(item);
	}
	
	public void deleteMovie(MovieDBItem item)
	{
		movieList.remove(item);
	}

	@Override
	public int compareTo(Genre o) {
		return this.getItem().compareTo(o.getItem());
	}

	@Override
	public int hashCode() {
		return this.getItem().hashCode();
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
        
        return true;
	}
	
}