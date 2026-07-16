public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        rearranging("",str);
    }
    static void rearranging(String pro,String unpro){
        if(unpro.isEmpty()){
            System.out.println(pro);
            return;
        }
        char ch = unpro.charAt(0);
        for(int i = 0; i <= pro.length();i++){
            String before = pro.substring(0,i);
            String after = pro.substring(i);
            rearranging(before + ch + after,unpro.substring(1));
        }
    }
}
