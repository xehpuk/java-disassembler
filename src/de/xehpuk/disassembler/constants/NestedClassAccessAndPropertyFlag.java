package de.xehpuk.disassembler.constants;

/**
 *
 * @author xehpuk
 */
public class NestedClassAccessAndPropertyFlag {
	/**
	 * Marked or implicitly
	 * <code>public</code> in source.
	 */
	public static final int PUBLIC = 0x0001;
	/**
	 * Marked
	 * <code>private</code> in source.
	 */
	public static final int PRIVATE = 0x0002;
	/**
	 * Marked
	 * <code>protected</code> in source.
	 */
	public static final int PROTECTED = 0x0004;
	/**
	 * Marked or implicitly
	 * <code>static</code> in source.
	 */
	public static final int STATIC = 0x0008;
	/**
	 * Marked
	 * <code>final</code> in source.
	 */
	public static final int FINAL = 0x0010;
	/**
	 * Was an
	 * <code>interface</code> in source.
	 */
	public static final int INTERFACE = 0x0200;
	/**
	 * Marked or implicitly
	 * <code>abstract</code> in source.
	 */
	public static final int ABSTRACT = 0x0400;
	/**
	 * Declared synthetic; not present in the source code.
	 */
	public static final int SYNTHETIC = 0x1000;
	/**
	 * Declared as an annotation type.
	 */
	public static final int ANNOTATION = 0x2000;
	/**
	 * Declared as an
	 * <code>enum</code> type.
	 */
	public static final int ENUM = 0x4000;
}