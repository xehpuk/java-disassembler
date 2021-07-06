package de.xehpuk.disassembler.constants;

/**
 *
 * @author xehpuk
 */
public class FieldAccessAndPropertyFlag {
	/**
	 * Declared
	 * <code>public</code>; may be accessed from outside its package.
	 */
	public static final int PUBLIC = 0x0001;
	/**
	 * Declared
	 * <code>private</code>; usable only within the defining class.
	 */
	public static final int PRIVATE = 0x0002;
	/**
	 * Declared
	 * <code>protected</code>; may be accessed within subclasses.
	 */
	public static final int PROTECTED = 0x0004;
	/**
	 * Declared
	 * <code>static</code>.
	 */
	public static final int STATIC = 0x0008;
	/**
	 * Declared
	 * <code>final</code>; never directly assigned to after object construction
	 * (JLS §17.5).
	 */
	public static final int FINAL = 0x0010;
	/**
	 * Declared
	 * <code>volatile</code>; cannot be cached.
	 */
	public static final int VOLATILE = 0x0040;
	/**
	 * Declared
	 * <code>transient</code>; not written or read by a persistent object
	 * manager.
	 */
	public static final int TRANSIENT = 0x0080;
	/**
	 * Declared synthetic; not present in the source code.
	 */
	public static final int SYNTHETIC = 0x1000;
	/**
	 * Declared as an element of an
	 * <code>enum</code>.
	 */
	public static final int ENUM = 0x4000;
}