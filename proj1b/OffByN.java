public class OffByN implements CharacterComparator{
    int offset;
    public OffByN(int N){
        this.offset = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff= x- y;
        return Math.abs(diff) == offset;
    }

}
