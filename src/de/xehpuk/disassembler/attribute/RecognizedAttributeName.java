package de.xehpuk.disassembler.attribute;

import de.xehpuk.disassembler.reader.AttributesReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xehpuk
 */
public enum RecognizedAttributeName implements AttributeName {
	CONSTANT_VALUE("ConstantValue") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readConstantValue();
		}
	},
	CODE("Code") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readCode();
		}
	},
	STACK_MAP_TABLE("StackMapTable") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readUnrecognized(UnrecognizedAttributeName.from(getName())); // TODO reader.readStackMapTable();
		}
	},
	EXCEPTIONS("Exceptions") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readExceptions();
		}
	},
	INNER_CLASSES("InnerClasses") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readInnerClasses();
		}
	},
	ENCLOSING_METHOD("EnclosingMethod") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readEnclosingMethod();
		}
	},
	SYNTHETIC("Synthetic") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readSynthetic();
		}
	},
	SIGNATURE("Signature") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readSignature();
		}
	},
	SOURCE_FILE("SourceFile") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readSourceFile();
		}
	},
	SOURCE_DEBUG_EXTENSION("SourceDebugExtension") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			System.err.println(getName());
			return reader.readUnrecognized(UnrecognizedAttributeName.from(getName())); // TODO reader.readSourceDebugExtension();
		}
	},
	LINE_NUMBER_TABLE("LineNumberTable") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readLineNumberTable();
		}
	},
	LOCAL_VARIABLE_TABLE("LocalVariableTable") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readLocalVariableTable();
		}
	},
	LOCAL_VARIABLE_TYPE_TABLE("LocalVariableTypeTable") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readLocalVariableTypeTable();
		}
	},
	DEPRECATED("Deprecated") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readDeprecated();
		}
	},
	RUNTIME_VISIBLE_ANNOTATIONS("RuntimeVisibleAnnotations") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readRuntimeVisibleAnnotations();
		}
	},
	RUNTIME_INVISIBLE_ANNOTATIONS("RuntimeInvisibleAnnotations") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readRuntimeInvisibleAnnotations();
		}
	},
	RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS("RuntimeVisibleParameterAnnotations") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readRuntimeVisibleParameterAnnotations();
		}
	},
	RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS("RuntimeInvisibleParameterAnnotations") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readRuntimeInvisibleParameterAnnotations();
		}
	},
	ANNOTATION_DEFAULT("AnnotationDefault") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readAnnotationDefault();
		}
	},
	BOOTSTRAP_METHODS("BootstrapMethods") {
		@Override
		public Attribute read(final AttributesReader reader) throws IOException {
			return reader.readBootstrapMethods();
		}
	};
	private static final Map<String, RecognizedAttributeName> nameLookup = new HashMap<>(values().length);

	static {
		for (final RecognizedAttributeName name : values()) {
			if (nameLookup.put(name.getName(), name) != null) {
				throw new IllegalArgumentException(name.getName());
			}
		}
	}

	public static RecognizedAttributeName from(final String name) {
		final RecognizedAttributeName result = nameLookup.get(name);
		return result;
	}
	private final String name;

	private RecognizedAttributeName(final String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}