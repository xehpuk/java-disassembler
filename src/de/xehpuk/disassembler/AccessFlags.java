package de.xehpuk.disassembler;

/**
 *
 * @author xehpuk
 */
public class AccessFlags {
	public static final int PUBLIC = 0x0001;
	public static final int PRIVATE = 0x0002;
	public static final int PROTECTED = 0x0004;
	public static final int STATIC = 0x0008;
	public static final int FINAL = 0x0010;
	public static final int SUPER = 0x0020;
	public static final int SYNCHRONIZED = 0x0020;
	public static final int BRIDGE = 0x0040;
	public static final int VOLATILE = 0x0040;
	public static final int TRANSIENT = 0x0080;
	public static final int VARARGS = 0x0080;
	public static final int NATIVE = 0x0100;
	public static final int INTERFACE = 0x0200;
	public static final int ABSTRACT = 0x0400;
	public static final int STRICT = 0x0800;
	public static final int SYNTHETIC = 0x1000;
	public static final int ANNOTATION = 0x2000;
	public static final int ENUM = 0x4000;
	private final int mask;
	private final Type type;

	public AccessFlags(final int mask, final Type type) {
		this.mask = mask;
		this.type = type;
	}

	public int getMask() {
		return mask;
	}

	public Type getType() {
		return type;
	}

	private boolean hasFlag(final int flag) {
		return (mask & flag) == flag;
	}

	public boolean isPublic() {
		return hasFlag(PUBLIC);
	}

	public boolean isPrivate() {
		return hasFlag(PRIVATE);
	}

	public boolean isProtected() {
		return hasFlag(PROTECTED);
	}

	public boolean isStatic() {
		return hasFlag(STATIC);
	}

	public boolean isFinal() {
		return hasFlag(FINAL);
	}

	public boolean isSuper() {
		return hasFlag(SUPER);
	}

	public boolean isSynchronized() {
		return hasFlag(SYNCHRONIZED);
	}

	public boolean isBridge() {
		return hasFlag(BRIDGE);
	}

	public boolean isVolatile() {
		return hasFlag(VOLATILE);
	}

	public boolean isTransient() {
		return hasFlag(SYNCHRONIZED);
	}

	public boolean isVarargs() {
		return hasFlag(VARARGS);
	}

	public boolean isNative() {
		return hasFlag(NATIVE);
	}

	public boolean isInterface() {
		return hasFlag(INTERFACE);
	}

	public boolean isAbstract() {
		return hasFlag(ABSTRACT);
	}

	public boolean isStrict() {
		return hasFlag(STRICT);
	}

	public boolean isSynthetic() {
		return hasFlag(SYNTHETIC);
	}

	public boolean isAnnotation() {
		return hasFlag(ANNOTATION);
	}

	public boolean isEnum() {
		return hasFlag(ENUM);
	}

	public static enum Type {
		CLASS, FIELD, METHOD, NESTED_CLASS;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		if (isPublic()) {
			sb.append("public ");
		} else {
			if (isProtected()) {
				sb.append("protected ");
			} else {
				if (isPrivate()) {
					sb.append("private ");
				}
			}
		}
		if (isStatic()) {
			sb.append("static ");
		}
		if (isAbstract()) {
			sb.append("abstract ");
		} else {
			if (isFinal()) {
				sb.append("final ");
			}
		}
		if (isNative()) {
			sb.append("native ");
		}
		if (type == Type.METHOD && isSynchronized()) {
			sb.append("synchronized ");
		}
		if (type == Type.METHOD && isVarargs()) {
			sb.append("varargs ");
		} else {
			if (type == Type.FIELD && isTransient()) {
				sb.append("transient ");
			}
		}
		if (type == Type.METHOD && isBridge()) {
			sb.append("bridge ");
		} else {
			if (isVolatile()) {
				sb.append("volatile ");
			}
		}
		if (isStrict()) {
			sb.append("strictfp ");
		}
		if (isInterface()) {
			sb.append("interface ");
			if (isAnnotation()) {
				sb.append("annotation ");
			}
		} else {
			if (isEnum()) {
				sb.append("enum ");
			}
		}
		return sb.toString();
	}
}