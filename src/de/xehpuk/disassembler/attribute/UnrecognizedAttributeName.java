package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.reader.AttributesReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UnrecognizedAttributeName implements AttributeName {
	private static final Map<String, UnrecognizedAttributeName> nameLookup = new HashMap<>();

	public static UnrecognizedAttributeName from(final String name) {
		UnrecognizedAttributeName result = nameLookup.get(name);
		if (result == null) {
			result = new UnrecognizedAttributeName(name);
			nameLookup.put(name, result);
		}
		return result;
	}
	private final String name;

	public UnrecognizedAttributeName(final String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public UnrecognizedAttribute read(final AttributesReader reader) throws IOException {
		return reader.readUnrecognized(this);
	}
}