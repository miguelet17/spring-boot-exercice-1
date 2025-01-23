package com.miguel.core.exceptions.specific_exception;

import com.miguel.core.exceptions.GenericException;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Value
public class BadRequestException  extends GenericException {

  public BadRequestException(@NonNull String textDescription) {
    super(textDescription);
  }
}
