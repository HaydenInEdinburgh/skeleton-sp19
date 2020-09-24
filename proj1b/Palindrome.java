import java.util.LinkedList;
import java.util.Queue;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new LinkedListDeque<>();
        for(int i=0; i< word.length(); i++){
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word){
        int start = 0;
        int end = word.length()-1;
        while(start< end){
            if(word.charAt(start) != word.charAt(end)){
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> deque = wordToDeque(word);
        while(deque.size()>1){
            Character start = deque.removeFirst();
            Character end = deque.removeLast();
            if(!cc.equalChars(start, end)){
                return false;
            }
        }
        return true;

    }
}
