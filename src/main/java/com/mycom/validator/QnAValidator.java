package com.mycom.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mycom.QnA.QnAModel;

public class QnAValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return QnAModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// memberModel을 유효성검사하는 타겟으로 잡음
		QnAModel qnaModel= (QnAModel) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contents", "contents");
	}
}