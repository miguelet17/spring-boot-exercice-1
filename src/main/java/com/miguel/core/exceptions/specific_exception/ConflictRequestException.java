package com.miguel.core.exceptions.specific_exception;

import com.miguel.core.exceptions.GenericException;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Value
public class ConflictRequestException extends GenericException {

  private static final long serialVersionUID = 810157209575535193L;

  public ConflictRequestException(@NonNull String textDescription) {
    super(textDescription);
  }
}
