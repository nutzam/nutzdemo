package nutz.demo.mvc.pet;

import java.io.File;
import java.io.IOException;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.service.IdNameEntityService;

@IocBean(field = { "dao" })
public class PetService extends IdNameEntityService<Pet> {

	public void uploadPhoto(int id, File tempFile, String root) throws IOException {
		// Get pet
		Pet pet = this.fetch(id);
		// Move the file to "$ROOT/photo/$id.$extension"
		String ext = Files.getSuffixName(tempFile);
		pet.setPhotoPath("/photo/" + id + "." + ext);
		File photo = new File(root + pet.getPhotoPath());
		if (photo.exists())
			Files.deleteFile(photo);
		Files.move(tempFile, photo);
		// Update the pets
		dao().update(pet);
	}
}
