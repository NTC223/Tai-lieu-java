public class Pair <T,U> {
    private T first;
    private U second;
//    public Pair(T first, U second)
//    {
//        this.first = first;
//        this.second = second;
//    }

    public
        T getFirst(){
            return this.first;
        }
        void setFirst(T first){
            this.first = first;
        }

        U getSecond(){
            return this.second;
        }
        void setSecond(U second){
            this.second = second;
        }
}
