package com.miguel.core.exceptions.specific_exception;

import com.miguel.core.exceptions.GenericException;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Value
public class GoneException extends GenericException {
  public GoneException(@NonNull String textDescription) {
    super(textDescription);
  }
  private static final long serialVersionUID = 4255360752065450591L;
}
