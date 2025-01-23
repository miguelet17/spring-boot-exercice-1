package com.miguel.core.exceptions.specific_exception;

import com.miguel.core.exceptions.GenericException;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Value
public class NoContentRequestException extends GenericException {
  private static final long serialVersionUID = -3562065104846263240L;

  public NoContentRequestException(@NonNull String textDescription) {
    super(textDescription);
  }
}
