package tquintas.pubq.Records;

import java.io.Serializable;

public record LoggedUser(Long id, String name) implements Serializable {
}
