package vch.example.spring_jpa;

public class Helper {
    private static final String prefix = "___";
    public static String bg = "<script>document.documentElement.style.background = '#ccc'</script>";
    public static void l(Object data) {
        System.out.println(prefix + data.toString());
//        switch (data) {
//            case String s: System.out.println(prefix +  data); break;
//            case Integer i: System.out.println(prefix +  data.toString()); break;
//            default: System.out.println(prefix +  "err data specified");
//        }
    }
}
