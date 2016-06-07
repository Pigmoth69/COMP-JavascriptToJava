public final class JS2Java {
    public static void main(String[] args) {
        try{
            myroutine();
        }catch(IOException e){
        }
        catch(IndexOutOfBoundsException e){
        }
        catch(UnsupportedOperationException e){
        }
        catch(Exception e){
            logMyErrors(e);
        }
    }

    public static void myroutine() {
        System.out.println("myroutine");
    }

    public static void logMyErrors(String e) {
        System.out.println("e");
    }
}
