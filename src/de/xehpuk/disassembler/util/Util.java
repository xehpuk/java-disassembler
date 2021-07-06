package de.xehpuk.disassembler.util;

import de.xehpuk.disassembler.Dumpable;
import de.xehpuk.disassembler.constants.BaseTypeCharacter;
import de.xehpuk.disassembler.exceptions.IllegalElementValueTagException;

/**
 *
 * @author xehpuk
 */
public class Util {
	private Util() {
	}

	public static int digits(final int number) {
		final int base = 10;
		int i = 1;
		for (int n = number; n >= base; n /= base, i++);
		return i;
	}

	public static String className(final String internal) {
		final String dotNotation = internal.replace('/', '.');
		return dotNotation.matches("java\\.lang\\.[^.]+") ? dotNotation.substring("java.lang.".length()) : dotNotation;
	}

	public static String constant(final String name) {
		final String prefix = "Constant";
		if (name.startsWith(prefix)) {
			return name.substring(prefix.length());
		}
		throw new IllegalArgumentException(name + " does not contain \n" + prefix + '"');
	}

	/**
	 *
	 * @param descriptor
	 * @return true if field, false if method
	 */
	public static boolean field(final String descriptor) {
		return descriptor.charAt(0) != '(';
	}

	public static String fieldDescriptor(final String descriptor) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0, a = 0; i < descriptor.length(); i++) {
			final char c = descriptor.charAt(i);
			if (c == BaseTypeCharacter.ARRAY) {
				a++;
			} else {
				if (i - a != 0) {
					sb.append(", ");
				}
				switch (c) {
					case BaseTypeCharacter.BYTE:
						sb.append("byte");
						break;
					case BaseTypeCharacter.CHAR:
						sb.append("char");
						break;
					case BaseTypeCharacter.DOUBLE:
						sb.append("double");
						break;
					case BaseTypeCharacter.FLOAT:
						sb.append("float");
						break;
					case BaseTypeCharacter.INT:
						sb.append("int");
						break;
					case BaseTypeCharacter.LONG:
						sb.append("long");
						break;
					case BaseTypeCharacter.REFERENCE:
						final int end = descriptor.indexOf(';', i);
						sb.append(className(descriptor.substring(i + 1, end)));
						i = end;
						break;
					case BaseTypeCharacter.SHORT:
						sb.append("short");
						break;
					case BaseTypeCharacter.BOOLEAN:
						sb.append("boolean");
						break;
					case BaseTypeCharacter.VOID:
						sb.append("void");
						break;
					default:
						throw new IllegalElementValueTagException(c);
				}
				for (int j = 0; j < a; j++) {
					sb.append("[]");
				}
				a = 0;
			}
		}
		return sb.toString();
	}

	public static String parameterDescriptor(final String descriptor) {
		final String parameterDescriptor = descriptor.substring(1, descriptor.indexOf(')'));
		final StringBuilder sb = new StringBuilder();
		sb.append('(').append(fieldDescriptor(parameterDescriptor)).append(')');
		return sb.toString();
	}

	public static String returnDescriptor(final String descriptor) {
		final String returnDescriptor = descriptor.substring(descriptor.indexOf(')') + 1);
		final StringBuilder sb = new StringBuilder();
		int a = 0;
		for (int i = 0; i < returnDescriptor.length(); i++, a++) {
			if (returnDescriptor.charAt(i) != BaseTypeCharacter.ARRAY) {
				break;
			}
		}
		final char c = returnDescriptor.charAt(a);
		switch (c) {
			case BaseTypeCharacter.BYTE:
				sb.append("byte");
				break;
			case BaseTypeCharacter.CHAR:
				sb.append("char");
				break;
			case BaseTypeCharacter.DOUBLE:
				sb.append("double");
				break;
			case BaseTypeCharacter.FLOAT:
				sb.append("float");
				break;
			case BaseTypeCharacter.INT:
				sb.append("int");
				break;
			case BaseTypeCharacter.LONG:
				sb.append("long");
				break;
			case BaseTypeCharacter.REFERENCE:
				sb.append(className(returnDescriptor.substring(a + 1, returnDescriptor.length() - 1)));
				break;
			case BaseTypeCharacter.SHORT:
				sb.append("short");
				break;
			case BaseTypeCharacter.BOOLEAN:
				sb.append("boolean");
				break;
			case BaseTypeCharacter.VOID:
				sb.append("void");
				break;
			default:
				throw new IllegalElementValueTagException(c);
		}
		for (int i = 0; i < a; i++) {
			sb.append("[]");
		}
		return sb.toString();
	}
	
	public static void indent(final int indent) {
		for (int i = 0; i < indent; i++) {
			for (int j = 0; j < Dumpable.INDENT; j++) {
				System.out.print(' ');
			}
		}
	}

	public static void requireNull(final Object ref) {
		if (ref != null) {
			throw new UnsupportedOperationException();
		}
	}
}