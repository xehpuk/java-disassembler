package de.xehpuk.disassembler.constants;

/**
 *
 * @author xehpuk
 */
public class ClassAccessAndPropertyModifier {
	/**
	 * Declared
	 * <code>public</code>; may be accessed from outside its package.
	 */
	public static final int PUBLIC = 0x0001;
	/**
	 * Declared
	 * <code>final</code>; no subclasses allowed.
	 */
	public static final int FINAL = 0x0010;
	/**
	 * Treat superclass methods specially when invoked by the
	 * <em>invokespecial</em> instruction.
	 */
	public static final int SUPER = 0x0020;
	/**
	 * Is an interface, not a class.
	 */
	public static final int INTERFACE = 0x0200;
	/**
	 * Declared
	 * <code>abstract</code>; must not be instantiated.
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