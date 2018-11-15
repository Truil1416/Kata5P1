
package kata5p1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class MailListReader {
    private final String fileName;

    public MailListReader(String fileName) {
        this.fileName = fileName;
    }
    
    public List<String> read(){
        List<String> lista = new LinkedList<>();
        
        Pattern p = Pattern.compile("^(.+)@(.+)$");
        try(Stream<String> s = Files.lines(Paths.get(fileName))){
            s.forEach(emails -> {
                if(p.matcher(emails).matches()){
                    lista.add(emails);
                }
            });
        }catch(IOException e){
            
        }
        
        return lista;
    }
}
