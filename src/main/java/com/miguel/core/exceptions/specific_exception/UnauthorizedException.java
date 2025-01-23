package com.miguel.core.exceptions.specific_exception;

import com.miguel.core.exceptions.GenericException;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Value
public class UnauthorizedException extends GenericException {
  private static final long serialVersionUID = -3094643482577564466L;
  public UnauthorizedException(@NonNull String textDescription) {
    super(textDescription);
  }
}
