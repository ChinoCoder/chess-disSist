package Games.Commons;

import java.util.Optional;

public class Result<T, R>{
    private final Optional<T> value;
    private final R error;

    public Result(Optional<T> value, R error){
        this.value = value;
        this.error = error;
    }

    public Optional<T> getValue(){
        return value;
    }

    public R getError(){
        return error;
    }
}
