package de.xehpuk.disassembler.constantpool;

import de.xehpuk.disassembler.constantpool.bytes.ConstantClassBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantDoubleBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantFieldrefBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantFloatBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantIntegerBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantInterfaceMethodrefBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantInvokeDynamicBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantLongBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantMethodHandleBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantMethodTypeBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantMethodrefBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantNameAndTypeBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantPoolEntryRaw;
import de.xehpuk.disassembler.constantpool.bytes.ConstantStringBytes;
import de.xehpuk.disassembler.constantpool.bytes.ConstantUtf8Bytes;
import de.xehpuk.disassembler.exceptions.IllegalConstantInfoTagException;
import de.xehpuk.disassembler.reader.ConstantPoolReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xehpuk
 */
public enum ConstantTag {
	CLASS(7) {
		@Override
		public ConstantClassBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantClassInfo();
		}
	},
	DOUBLE(6) {
		@Override
		public ConstantDoubleBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantDoubleInfo();
		}
	},
	FIELDREF(9) {
		@Override
		public ConstantFieldrefBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantFieldrefInfo();
		}
	},
	FLOAT(4) {
		@Override
		public ConstantFloatBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantFloatInfo();
		}
	},
	INTEGER(3) {
		@Override
		public ConstantIntegerBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantIntegerInfo();
		}
	},
	INTERFACE_METHODREF(11) {
		@Override
		public ConstantInterfaceMethodrefBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantInterfaceMethodrefInfo();
		}
	},
	INVOKE_DYNAMIC(18) {
		@Override
		public ConstantInvokeDynamicBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantInvokeDynamicInfo();
		}
	},
	LONG(5) {
		@Override
		public ConstantLongBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantLongInfo();
		}
	},
	METHOD_HANDLE(15) {
		@Override
		public ConstantMethodHandleBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantMethodHandleInfo();
		}
	},
	METHOD_TYPE(16) {
		@Override
		public ConstantMethodTypeBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantMethodTypeInfo();
		}
	},
	METHODREF(10) {
		@Override
		public ConstantMethodrefBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantMethodrefInfo();
		}
	},
	NAME_AND_TYPE(12) {
		@Override
		public ConstantNameAndTypeBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantNameAndTypeInfo();
		}
	},
	STRING(8) {
		@Override
		public ConstantStringBytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantStringInfo();
		}
	},
	UTF8(1) {
		@Override
		public ConstantUtf8Bytes read(final ConstantPoolReader reader) throws IOException {
			return reader.readConstantUtf8Info();
		}
	};
	private static final Map<Integer, ConstantTag> tagLookup = new HashMap<>(values().length);

	static {
		for (final ConstantTag tag : values()) {
			if (tagLookup.put(tag.getTag(), tag) != null) {
				throw new IllegalConstantInfoTagException(tag.getTag());
			}
		}
	}

	public static ConstantTag from(final int tag) throws IllegalConstantInfoTagException {
		final ConstantTag result = tagLookup.get(tag);
		if (result == null) {
			throw new IllegalConstantInfoTagException(tag);
		}
		return result;
	}
	private final int tag;

	private ConstantTag(final int tag) {
		this.tag = tag;
	}

	public int getTag() {
		return tag;
	}

	public abstract ConstantPoolEntryRaw read(ConstantPoolReader reader) throws IOException;
}