package Pegas.db;

import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class UserRepository {
    private String userName;
    private int poolSize;
    private List<Object> args;
    private Map<String, Object> properties;
    public void init(){
        System.out.println("init UserRepository");
    }
    public void destroy(){
        System.out.println("destroy UserRepository");
    }
}
