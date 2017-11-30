package br.com.vitrinegastronomica.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vitrinegastronomica.models.Category;

@FacesConverter("categoryConverter")
public class CategoryConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {

		System.out.println("Convertendo para Objeto " + id);
		if (id == null && id.trim().isEmpty())
			return null;

		Category category = new Category();
		category.setId(Integer.valueOf(id));

		return category;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object categoryObject) {

		System.out.println("Convertendo para String " + categoryObject);
		if (categoryObject == null)
			return null;

		Category category = (Category) categoryObject;
		return category.getId().toString();
	}

}
