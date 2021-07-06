package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.reader.AttributesReader;
import java.io.IOException;

public interface AttributeName {
	String getName();

	Attribute read(AttributesReader reader) throws IOException;

	public static class Getter {
		public static AttributeName from(final String name) {
			AttributeName result = RecognizedAttributeName.from(name);
			if (result == null) {
				result = UnrecognizedAttributeName.from(name);
			}
			return result;
		}
	}
}