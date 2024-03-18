package Pegas.db;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
public class UserRepository {
    private String userName;
    private int poolSize;
    private List<Object> args;
    private Map<String, Object> properties;
}
