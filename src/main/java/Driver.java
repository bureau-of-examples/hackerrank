import java.io.InputStream;
import java.lang.reflect.Method;

public class Driver {

    private static void runSolution(String packageName) throws Exception{

        Method mainMethod = Class.forName(packageName + ".Solution").getMethod("main", new Class[]{String[].class});
        mainMethod.setAccessible(true);
        int count = 1;
        while (true){
            InputStream stdin = Driver.class.getClassLoader().getResourceAsStream(packageName.replace('.', '/') + (count == 1 ? "" : String.valueOf(count)) + ".tc");
            if(stdin == null){
                if(count == 1)
                    throw new RuntimeException("Need at least one test case.");
                else
                    break;
            }
            System.out.println("=====Start test batch " + count + "=====");
            System.setIn(stdin);
            mainMethod.invoke(null, new Object[]{new String[0]});
            count++;
        }
    }

    public static void main(String[] args) throws Exception {

        //runSolution("warmup.utopiantree");
        //runSolution("warmup.maximizingxor");
        //runSolution("warmup.servicelane");
        //runSolution("warmup.thelovelettermystery");
        //runSolution("warmup.lonelyinteger");
        //testComplexity();
        //runSolution("warmup.cutthesticks");
        //runSolution("warmup.angryprofessor");
        //runSolution("warmup.halloweenparty");
        //runSolution("warmup.isfibo");
        //runSolution("warmup.maxmin");
        //runSolution("warmup.finddigits");
        //runSolution("warmup.chocolatefeast");
        //runSolution("warmup.cavitymap");
        //runSolution("warmup.manasaandstones");
        //runSolution("warmup.acmicpcteam");
        //runSolution("warmup.taumandbday");
        //runSolution("warmup.sherlockandsquares");
        //runSolution("warmup.sherlockandgcd");
        //runSolution("warmup.sherlockandthebeast");
        //runSolution("warmup.fillingjars");
        //runSolution("strings.pangrams");
        //runSolution("strings.alternatingcharacters");
        //runSolution("strings.gameofthronesi");
        //runSolution("strings.gemstones");
        //runSolution("strings.funnystring");
        //runSolution("strings.makeitanagram");
        //runSolution("strings.anagram");
        //runSolution("strings.twostrings");
        //runSolution("strings.biggerisgreater");
        //runSolution("strings.sherlockandanagrams");
        //runSolution("sorting.intrototutorial");
        //runSolution("sorting.insertionsort1");
        //runSolution("sorting.insertionsort2");
        //runSolution("sorting.correctnessandtheloopinvariant");
        //runSolution("sorting.runningtime");
        //runSolution("sorting.quicksort1");
        //runSolution("sorting.quicksort2");
        //runSolution("sorting.quicksort3");
        //runSolution("sorting.quicksort4");
        //runSolution("sorting.countingsort1");
        //runSolution("sorting.countingsort2");
        //runSolution("sorting.countingsort3");
        //runSolution("sorting.countingsort4");
        //runSolution("search.connectedcellinagrid");
        //runSolution("search.findmaximumindexproduct");
        //runSolution("search.icecreamparlor");
        //runSolution("search.encryption");
        //runSolution("search.countluck");
        runSolution("search.sherlockandarray");
    }
}
