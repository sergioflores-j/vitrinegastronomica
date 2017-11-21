package br.com.vitrinegastronomica.infra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;

import javax.servlet.http.Part;

public class FileSaver {

	public static final String SERVER_PATH = "/temporaria";

	public String write(Part file, String path) {
		// Pega o "Part" e "escreve" em disco na pasta passada, a partir da ra�z
		// do sistema com o nome do file que foi enviado
		System.out.println("O ARQUIVO É " + path + "/" + file.getSubmittedFileName());
		String relativePath = path + "/" + file.getSubmittedFileName();

		try {
			file.write(SERVER_PATH + "/" + relativePath);

			return relativePath;

		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public static void transfer(Path source, OutputStream outputStream) {
		// Try with resources abre e fecha os channels, que necessitam ser
		// fechados
		try {
			FileInputStream input = new FileInputStream(source.toFile());
			try (ReadableByteChannel inputChannel = Channels.newChannel(input);
					WritableByteChannel outputChannel = Channels.newChannel(outputStream)) {

				// Aloca de 10 em 10 KB
				ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 10);

				// Enquanto o tamanho do buffer for diferente de 1, o canal l�
				// ele
				while (inputChannel.read(buffer) != -1) {
					// Seta os bytes pra 0 de novo
					buffer.flip();
					// Escreve no output o buffer
					outputChannel.write(buffer);
					// Limpa para ler outro
					buffer.clear();
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}
}
