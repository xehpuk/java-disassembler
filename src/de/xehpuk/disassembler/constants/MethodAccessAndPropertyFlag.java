package de.xehpuk.disassembler.constants;

/**
 *
 * @author xehpuk
 */
public class MethodAccessAndPropertyFlag {
	/**
	 * Declared
	 * <code>public</code>; may be accessed from outside its package.
	 */
	public static final int PUBLIC = 0x0001;
	/**
	 * Declared
	 * <code>private</code>; accessible only within the defining class.
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
	 * <code>final</code>; must not be overridden (<a class="xref"
	 * href="jvms-5.html#jvms-5.4.5" title="5.4.5.&nbsp;Method
	 * overriding">&sect;5.4.5</a>).
	 */
	public static final int FINAL = 0x0010;
	/**
	 * Declared
	 * <code>synchronized</code>; invocation is wrapped by a monitor use.
	 */
	public static final int SYNCHRONIZED = 0x0020;
	/**
	 * A bridge method, generated by the compiler.
	 */
	public static final int BRIDGE = 0x0040;
	/**
	 * Declared with variable number of arguments.
	 */
	public static final int VARARGS = 0x0080;
	/**
	 * Declared
	 * <code>native</code>; implemented in a language other than Java.
	 */
	public static final int NATIVE = 0x0100;
	/**
	 * Declared
	 * <code>abstract</code>; no implementation is provided.
	 */
	public static final int ABSTRACT = 0x0400;
	/**
	 * Declared
	 * <code>strictfp</code>; floating-point mode is FP-strict.
	 */
	public static final int STRICT = 0x0800;
	/**
	 * Declared synthetic; not present in the source code.
	 */
	public static final int SYNTHETIC = 0x1000;
}