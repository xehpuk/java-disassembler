package de.xehpuk.disassembler.constants;

import de.xehpuk.disassembler.attribute.AnnotationValue;
import de.xehpuk.disassembler.attribute.ArrayValue;
import de.xehpuk.disassembler.attribute.ClassInfo;
import de.xehpuk.disassembler.attribute.ElementValue;
import de.xehpuk.disassembler.attribute.EnumConstValue;
import de.xehpuk.disassembler.constantpool.model.ConstantDouble;
import de.xehpuk.disassembler.constantpool.model.ConstantFloat;
import de.xehpuk.disassembler.constantpool.model.ConstantInteger;
import de.xehpuk.disassembler.constantpool.model.ConstantLong;
import de.xehpuk.disassembler.constantpool.model.ConstantUtf8;
import de.xehpuk.disassembler.exceptions.IllegalElementValueTagException;
import de.xehpuk.disassembler.reader.AttributesReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xehpuk
 */
public enum TypeCharacter {
	BYTE('B') {
		@Override
		public ConstantInteger read(final AttributesReader reader) throws IOException {
			return reader.readConstantInteger();
		}
	},
	CHAR('C') {
		@Override
		public ConstantInteger read(final AttributesReader reader) throws IOException {
			return reader.readConstantInteger();
		}
	},
	DOUBLE('D') {
		@Override
		public ConstantDouble read(final AttributesReader reader) throws IOException {
			return reader.readConstantDouble();
		}
	},
	FLOAT('F') {
		@Override
		public ConstantFloat read(final AttributesReader reader) throws IOException {
			return reader.readConstantFloat();
		}
	},
	INT('I') {
		@Override
		public ConstantInteger read(final AttributesReader reader) throws IOException {
			return reader.readConstantInteger();
		}
	},
	LONG('J') {
		@Override
		public ConstantLong read(final AttributesReader reader) throws IOException {
			return reader.readConstantLong();
		}
	},
	REFERENCE('L') {
		@Override
		public ElementValue read(final AttributesReader reader) {
			throw new IllegalElementValueTagException(getTag());
		}
	},
	SHORT('S') {
		@Override
		public ConstantInteger read(final AttributesReader reader) throws IOException {
			return reader.readConstantInteger();
		}
	},
	BOOLEAN('Z') {
		@Override
		public ConstantInteger read(final AttributesReader reader) throws IOException {
			return reader.readConstantInteger();
		}
	},
	ARRAY('[') {
		@Override
		public ArrayValue read(final AttributesReader reader) throws IOException {
			return reader.readArrayValue();
		}
	},
	VOID('V') {
		@Override
		public ElementValue read(final AttributesReader reader) {
			throw new IllegalElementValueTagException(getTag());
		}
	},
	STRING('s') {
		@Override
		public ConstantUtf8 read(final AttributesReader reader) throws IOException {
			return reader.readConstantUtf8();
		}
	},
	ENUM_CONSTANT('e') {
		@Override
		public EnumConstValue read(final AttributesReader reader) throws IOException {
			return reader.readEnumConstValue();
		}
	},
	CLASS('c') {
		@Override
		public ClassInfo read(final AttributesReader reader) throws IOException {
			return reader.readClassInfo();
		}
	},
	ANNOTATION_TYPE('@') {
		@Override
		public AnnotationValue read(final AttributesReader reader) throws IOException {
			return reader.readAnnotationValue();
		}
	};
	private static final Map<Character, TypeCharacter> tagLookup = new HashMap<>(values().length);

	static {
		for (final TypeCharacter tag : values()) {
			if (tagLookup.put(tag.getTag(), tag) != null) {
				throw new IllegalElementValueTagException(tag.getTag());
			}
		}
	}

	public static TypeCharacter from(final char tag) throws IllegalElementValueTagException {
		final TypeCharacter result = tagLookup.get(tag);
		if (result == null) {
			throw new IllegalElementValueTagException(tag);
		}
		return result;
	}
	private final char tag;

	private TypeCharacter(final char tag) {
		this.tag = tag;
	}

	public char getTag() {
		return tag;
	}

	public abstract ElementValue read(AttributesReader reader) throws IOException;
}