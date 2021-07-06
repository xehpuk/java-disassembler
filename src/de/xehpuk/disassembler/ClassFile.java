package de.xehpuk.disassembler;

import de.xehpuk.disassembler.attribute.Attribute;
import de.xehpuk.disassembler.constantpool.ConstantPool;
import de.xehpuk.disassembler.constantpool.model.ConstantClass;
import de.xehpuk.disassembler.util.Util;
import java.util.Arrays;

/**
 * <pre>ClassFile {
 * u4             MAGIC;
 * u2             minorVersion;
 * u2             majorVersion;
 * u2             constantPoolCount;
 * cp_info        constant_pool[constantPoolCount-1];
 * u2             accessFlags;
 * u2             thisClass;
 * u2             superClass;
 * u2             interfacesCount;
 * u2             interfaces[interfacesCount];
 * u2             fieldsCount;
 * field_info     fields[fieldsCount];
 * u2             methodsCount;
 * method_info    methods[methodsCount];
 * u2             attributesCount;
 * attribute_info attributes[attributesCount];
 * }</pre>
 *
 * @author xehpuk
 */
public class ClassFile implements Dumpable {
	/**
	 * <p><a name="jvms-4.1-200-A"></a>The
	 * <code>MAGIC</code> item supplies the MAGIC number identifying the
	 * <code>class</code> file format; it has the value
	 * <code>0xCAFEBABE</code>.</p>
	 */
	public static final int MAGIC = 0xCAFEBABE;
	/**
	 * @see #majorVersion
	 */
	private final int minorVersion;
	/**
	 * <p><a name="jvms-4.1-200-B"></a>The values of the
	 * <code>minorVersion</code> and
	 * <code>majorVersion</code> items are the minor and major version numbers
	 * of this
	 * <code>class</code> file. Together, a major and a minor version number
	 * determine the version of the
	 * <code>class</code> file format. If a
	 * <code>class</code> file has major version number M and minor version
	 * number m, we denote the version of its
	 * <code>class</code> file format as M.m. Thus,
	 * <code>class</code> file format versions may be ordered lexicographically,
	 * for example, 1.5 &lt; 2.0 &lt; 2.1. </p> <p><a
	 * name="jvms-4.1-200-B.1"></a>A Java virtual machine implementation can
	 * support a
	 * <code>class</code> file format of version v if and only if v lies in some
	 * contiguous range Mi.0 &#8804; v &#8804; Mj.m. The release level of the
	 * Java platform to which a Java virtual machine implementation conforms is
	 * responsible for determining the range. </p> <p>Oracle's Java virtual
	 * machine implementation in JDK release 1.0.2 supports
	 * <code>class</code> file format versions 45.0 through 45.3 inclusive. JDK
	 * releases 1.1.X support
	 * <code>class</code> file format versions in the range 45.0 through
	 * 45.65535 inclusive. For k &#8805; 2, implementations of version 1.k of
	 * the Java platform support
	 * <code>class</code> file format versions in the range 45.0 through 44+k.0
	 * inclusive. </p>
	 */
	private final int majorVersion;
	/**
	 * <p><a name="jvms-4.1-200-D"></a>The
	 * <code>constant_pool</code> is a table of structures (<a class="xref"
	 * href="jvms-4.html#jvms-4.4" title="4.4.&nbsp;The Constant
	 * Pool">&sect;4.4</a>) representing various string constants, class and
	 * interface names, field names, and other constants that are referred to
	 * within the
	 * <code>ClassFile</code> structure and its substructures. The format of
	 * each
	 * <code>constant_pool</code> table entry is indicated by its first "tag"
	 * byte. </p> <p><a name="jvms-4.1-200-D.1"></a>The
	 * <code>constant_pool</code> table is indexed from 1 to
	 * <code>constantPoolCount</code>-1. </p>
	 */
	private final ConstantPool constantPool;
	/**
	 * <p><a name="jvms-4.1-200-E"></a>The value of the
	 * <code>accessFlags</code> item is a mask of flags used to denote access
	 * permissions to and properties of this class or interface. The
	 * interpretation of each flag, when set, is as shown in <a class="xref"
	 * href="jvms-4.html#jvms-4.1-200-E.1" title="Table&nbsp;4.1.&nbsp;Class
	 * access and property modifiers">Table&nbsp;4.1</a>. </p> <div
	 * class="table"><a name="jvms-4.1-200-E.1"></a><p
	 * class="title"><b>Table&nbsp;4.1.&nbsp;Class access and property
	 * modifiers</b></p> <div class="table-contents"> <table summary="Class
	 * access and property modifiers" border="1"> <colgroup> <col> <col> <col>
	 * </colgroup> <thead> <tr> <th>Flag Name</th> <th>Value</th>
	 * <th>Interpretation</th> </tr> </thead> <tbody> <tr>
	 * <td><code>ACC_PUBLIC</code></td> <td>0x0001</td> <td>Declared
	 * <code>public</code>; may be accessed from outside its package. </td>
	 * </tr> <tr> <td><code>ACC_FINAL</code></td> <td>0x0010</td> <td>Declared
	 * <code>final</code>; no subclasses allowed. </td> </tr> <tr>
	 * <td><code>ACC_SUPER</code></td> <td>0x0020</td> <td>Treat superclass
	 * methods specially when invoked by the <span
	 * class="emphasis"><em>invokespecial</em></span> instruction. </td> </tr>
	 * <tr> <td><code>ACC_INTERFACE</code></td> <td>0x0200</td> <td>Is an
	 * interface, not a class.</td> </tr> <tr>
	 * <td><code>ACC_ABSTRACT</code></td> <td>0x0400</td> <td>Declared
	 * <code>abstract</code>; must not be instantiated. </td> </tr> <tr>
	 * <td><code>ACC_SYNTHETIC</code></td> <td>0x1000</td> <td>Declared
	 * synthetic; not present in the source code. </td> </tr> <tr>
	 * <td><code>ACC_ANNOTATION</code></td> <td>0x2000</td> <td>Declared as an
	 * annotation type.</td> </tr> <tr> <td><code>ACC_ENUM</code></td>
	 * <td>0x4000</td> <td>Declared as an
	 * <code>enum</code> type. </td> </tr> </tbody> </table> </div> </div><br
	 * class="table-break"><p><a name="jvms-4.1-200-E.2"></a>A class may be
	 * marked with the
	 * <code>ACC_SYNTHETIC</code> flag to indicate that it was generated by the
	 * compiler and does not appear in the source code. </p> <p><a
	 * name="jvms-4.1-200-E.3"></a>The
	 * <code>ACC_ENUM</code> flag indicates that this class or its superclass is
	 * declared as an enumerated type. </p> <p><a name="jvms-4.1-200-E.4"></a>An
	 * interface is distinguished by its
	 * <code>ACC_INTERFACE</code> flag being set. If its
	 * <code>ACC_INTERFACE</code> flag is not set, this
	 * <code>class</code> file defines a class, not an interface. </p> <p><a
	 * name="jvms-4.1-200-E.5"></a>If the
	 * <code>ACC_INTERFACE</code> flag of this
	 * <code>class</code> file is set, its
	 * <code>ACC_ABSTRACT</code> flag must also be set (JLS &sect;9.1.1.1). Such
	 * a
	 * <code>class</code> file must not have its
	 * <code>ACC_FINAL</code>,
	 * <code>ACC_SUPER</code> or
	 * <code>ACC_ENUM</code> flags set. </p> <p><a
	 * name="jvms-4.1-200-E.6"></a>An annotation type must have its
	 * <code>ACC_ANNOTATION</code> flag set. If the
	 * <code>ACC_ANNOTATION</code> flag is set, the
	 * <code>ACC_INTERFACE</code> flag must be set as well. If the
	 * <code>ACC_INTERFACE</code> flag of this
	 * <code>class</code> file is not set, it may have any of the other flags in
	 * <a class="xref" href="jvms-4.html#jvms-4.1-200-E.1"
	 * title="Table&nbsp;4.1.&nbsp;Class access and property
	 * modifiers">Table&nbsp;4.1</a> set, except the
	 * <code>ACC_ANNOTATION</code> flag. However, such a
	 * <code>class</code> file cannot have both its
	 * <code>ACC_FINAL</code> and
	 * <code>ACC_ABSTRACT</code> flags set (JLS &sect;8.1.1.2). </p> <p><a
	 * name="jvms-4.1-200-E.7"></a>The
	 * <code>ACC_SUPER</code> flag indicates which of two alternative semantics
	 * is to be expressed by the <span
	 * class="emphasis"><em>invokespecial</em></span> instruction (<a
	 * class="xref" href="jvms-6.html#jvms-6.5.invokespecial"
	 * title="invokespecial">&sect;<span
	 * class="emphasis"><em>invokespecial</em></span></a>) if it appears in this
	 * class. Compilers to the instruction set of the Java virtual machine
	 * should set the
	 * <code>ACC_SUPER</code> flag. </p> <p class="note">The
	 * <code>ACC_SUPER</code> flag exists for backward compatibility with code
	 * compiled by older compilers for the Java programming language. In
	 * Oracle&#8217;s JDK prior to release 1.0.2, the compiler generated
	 * <code>ClassFile</code>
	 * <code>accessFlags</code> in which the flag now representing
	 * <code>ACC_SUPER</code> had no assigned meaning, and Oracle's Java virtual
	 * machine implementation ignored the flag if it was set. </p> <p><a
	 * name="jvms-4.1-200-E.8"></a>All bits of the
	 * <code>accessFlags</code> item not assigned in <a class="xref"
	 * href="jvms-4.html#jvms-4.1-200-E.1" title="Table&nbsp;4.1.&nbsp;Class
	 * access and property modifiers">Table&nbsp;4.1</a> are reserved for future
	 * use. They should be set to zero in generated
	 * <code>class</code> files and should be ignored by Java virtual machine
	 * implementations. </p>
	 */
	private final AccessFlags accessFlags;
	/**
	 * <p><a name="jvms-4.1-200-F"></a>The value of the
	 * <code>thisClass</code> item must be a valid index into the
	 * <code>constant_pool</code> table. The
	 * <code>constant_pool</code> entry at that index must be a
	 * <code>CONSTANT_Class_info</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.4.1" title="4.4.1.&nbsp;The CONSTANT_Class_info
	 * Structure">&sect;4.4.1</a>) structure representing the class or interface
	 * defined by this
	 * <code>class</code> file. </p>
	 */
	private final ConstantClass thisClass;
	/**
	 * <p><a name="jvms-4.1-200-G"></a>For a class, the value of the
	 * <code>superClass</code> item either must be zero or must be a valid index
	 * into the
	 * <code>constant_pool</code> table. If the value of the
	 * <code>superClass</code> item is nonzero, the
	 * <code>constant_pool</code> entry at that index must be a
	 * <code>CONSTANT_Class_info</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.4.1" title="4.4.1.&nbsp;The CONSTANT_Class_info
	 * Structure">&sect;4.4.1</a>) structure representing the direct superclass
	 * of the class defined by this
	 * <code>class</code> file. Neither the direct superclass nor any of its
	 * superclasses may have the
	 * <code>ACC_FINAL</code> flag set in the
	 * <code>accessFlags</code> item of its
	 * <code>ClassFile</code> structure. </p> <p><a
	 * name="jvms-4.1-200-G.1"></a>If the value of the
	 * <code>superClass</code> item is zero, then this
	 * <code>class</code> file must represent the class
	 * <code>Object</code>, the only class or interface without a direct
	 * superclass. </p> <p><a name="jvms-4.1-200-G.2"></a>For an interface, the
	 * value of the
	 * <code>superClass</code> item must always be a valid index into the
	 * <code>constant_pool</code> table. The
	 * <code>constant_pool</code> entry at that index must be a
	 * <code>CONSTANT_Class_info</code> structure representing the class
	 * <code>Object</code>.</p>
	 */
	private final ConstantClass superClass;
	/**
	 * <p><a name="jvms-4.1-200-I"></a>Each value in the
	 * <code>interfaces</code> array must be a valid index into the
	 * <code>constant_pool</code> table. The
	 * <code>constant_pool</code> entry at each value of
	 * <code>interfaces[<span
	 * class="emphasis"><em>i</em></span>]</code>, where 0 &#8804; <span
	 * class="emphasis"><em>i</em></span> &lt;
	 * <code>interfacesCount</code>, must be a
	 * <code>CONSTANT_Class_info</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.4.1" title="4.4.1.&nbsp;The CONSTANT_Class_info
	 * Structure">&sect;4.4.1</a>) structure representing an interface that is a
	 * direct superinterface of this class or interface type, in the
	 * left-to-right order given in the source for the type. </p>
	 */
	private final ConstantClass[] interfaces;
	/**
	 * <p><a name="jvms-4.1-200-K"></a>Each value in the
	 * <code>fields</code> table must be a
	 * <code>field_info</code> (<a class="xref" href="jvms-4.html#jvms-4.5"
	 * title="4.5.&nbsp;Fields">&sect;4.5</a>) structure giving a complete
	 * description of a field in this class or interface. The
	 * <code>fields</code> table includes only those fields that are declared by
	 * this class or interface. It does not include items representing fields
	 * that are inherited from superclasses or superinterfaces. </p>
	 */
	private final Field[] fields;
	/**
	 * <p><a name="jvms-4.1-200-M"></a>Each value in the
	 * <code>methods</code> table must be a
	 * <code>method_info</code> (<a class="xref" href="jvms-4.html#jvms-4.6"
	 * title="4.6.&nbsp;Methods">&sect;4.6</a>) structure giving a complete
	 * description of a method in this class or interface. If neither of the
	 * <code>ACC_NATIVE</code> and
	 * <code>ACC_ABSTRACT</code> flags are set in the
	 * <code>accessFlags</code> item of a
	 * <code>method_info</code> structure, the Java virtual machine instructions
	 * implementing the method are also supplied. </p> <p><a
	 * name="jvms-4.1-200-M.1"></a>The
	 * <code>method_info</code> structures represent all methods declared by
	 * this class or interface type, including instance methods, class methods,
	 * instance initialization methods (<a class="xref"
	 * href="jvms-2.html#jvms-2.9" title="2.9.&nbsp;Special
	 * Methods">&sect;2.9</a>), and any class or interface initialization method
	 * (<a class="xref" href="jvms-2.html#jvms-2.9" title="2.9.&nbsp;Special
	 * Methods">&sect;2.9</a>). The
	 * <code>methods</code> table does not include items representing methods
	 * that are inherited from superclasses or superinterfaces. </p>
	 */
	private final Method[] methods;
	/**
	 * <p><a name="jvms-4.1-200-O"></a>Each value of the
	 * <code>attributes</code> table must be an
	 * <code>attribute_info</code> (<a class="xref" href="jvms-4.html#jvms-4.7"
	 * title="4.7.&nbsp;Attributes">&sect;4.7</a>) structure. </p> <p><a
	 * name="jvms-4.1-200-O.1"></a>The attributes defined by this specification
	 * as appearing in the
	 * <code>attributes</code> table of a
	 * <code>ClassFile</code> structure are the
	 * <code>InnerClasses</code> (<a class="xref" href="jvms-4.html#jvms-4.7.6"
	 * title="4.7.6.&nbsp;The InnerClasses Attribute">&sect;4.7.6</a>),
	 * <code>EnclosingMethod</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.7.7" title="4.7.7.&nbsp;The EnclosingMethod
	 * Attribute">&sect;4.7.7</a>),
	 * <code>Synthetic</code> (<a class="xref" href="jvms-4.html#jvms-4.7.8"
	 * title="4.7.8.&nbsp;The Synthetic Attribute">&sect;4.7.8</a>),
	 * <code>Signature</code> (<a class="xref" href="jvms-4.html#jvms-4.7.9"
	 * title="4.7.9.&nbsp;The Signature Attribute">&sect;4.7.9</a>),
	 * <code>SourceFile</code> (<a class="xref" href="jvms-4.html#jvms-4.7.10"
	 * title="4.7.10.&nbsp;The SourceFile Attribute">&sect;4.7.10</a>),
	 * <code>SourceDebugExtension</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.7.11" title="4.7.11.&nbsp;The
	 * SourceDebugExtension Attribute">&sect;4.7.11</a>),
	 * <code>Deprecated</code> (<a class="xref" href="jvms-4.html#jvms-4.7.15"
	 * title="4.7.15.&nbsp;The Deprecated Attribute">&sect;4.7.15</a>),
	 * <code>RuntimeVisibleAnnotations</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.7.16" title="4.7.16.&nbsp;The
	 * RuntimeVisibleAnnotations attribute">&sect;4.7.16</a>),
	 * <code>RuntimeInvisibleAnnotations</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.7.17" title="4.7.17.&nbsp;The
	 * RuntimeInvisibleAnnotations attribute">&sect;4.7.17</a>), and
	 * <code>BootstrapMethods</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.7.21" title="4.7.21.&nbsp;The BootstrapMethods
	 * attribute">&sect;4.7.21</a>) attributes. </p> <p><a
	 * name="jvms-4.1-200-O.2"></a>If a Java virtual machine implementation
	 * recognizes
	 * <code>class</code> files whose version number is 49.0 or above, it must
	 * recognize and correctly read
	 * <code>Signature</code> (<a class="xref" href="jvms-4.html#jvms-4.7.9"
	 * title="4.7.9.&nbsp;The Signature Attribute">&sect;4.7.9</a>),
	 * <code>RuntimeVisibleAnnotations</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.7.16" title="4.7.16.&nbsp;The
	 * RuntimeVisibleAnnotations attribute">&sect;4.7.16</a>), and
	 * <code>RuntimeInvisibleAnnotations</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.7.17" title="4.7.17.&nbsp;The
	 * RuntimeInvisibleAnnotations attribute">&sect;4.7.17</a>) attributes found
	 * in the
	 * <code>attributes</code> table of a
	 * <code>ClassFile</code> structure of a
	 * <code>class</code> file whose version number is 49.0 or above. </p> <p><a
	 * name="jvms-4.1-200-O.3"></a>If a Java virtual machine implementation
	 * recognizes
	 * <code>class</code> files whose version number is 51.0 or above, it must
	 * recognize and correctly read
	 * <code>BootstrapMethods</code> (<a class="xref"
	 * href="jvms-4.html#jvms-4.7.21" title="4.7.21.&nbsp;The BootstrapMethods
	 * attribute">&sect;4.7.21</a>) attributes found in the
	 * <code>attributes</code> table of a
	 * <code>ClassFile</code> structure of a
	 * <code>class</code> file whose version number is 51.0 or above. </p> <p><a
	 * name="jvms-4.1-200-O.4"></a>A Java virtual machine implementation is
	 * required to silently ignore any or all attributes in the
	 * <code>attributes</code> table of a
	 * <code>ClassFile</code> structure that it does not recognize. Attributes
	 * not defined in this specification are not allowed to affect the semantics
	 * of the
	 * <code>class</code> file, but only to provide additional descriptive
	 * information (<a class="xref" href="jvms-4.html#jvms-4.7.1"
	 * title="4.7.1.&nbsp;Defining and Naming New Attributes">&sect;4.7.1</a>).
	 * </p>
	 */
	private final Attribute[] attributes;

	public ClassFile(final ClassFileHead head, final ClassFileBody body) {
		this.minorVersion = head.getMinorVersion();
		this.majorVersion = head.getMajorVersion();
		this.accessFlags = head.getAccessFlags();
		this.constantPool = head.getConstantPool();
		this.thisClass = body.getThisClass();
		this.superClass = body.getSuperClass();
		this.interfaces = body.getInterfaces();
		this.fields = body.getFields();
		this.methods = body.getMethods();
		this.attributes = body.getAttributes();
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	/**
	 * <p><a name="jvms-4.1-200-C"></a>The value of the
	 * <code>constantPoolCount</code> item is equal to the number of entries in
	 * the
	 * <code>constant_pool</code> table plus one. A
	 * <code>constant_pool</code> index is considered valid if it is greater
	 * than zero and less than
	 * <code>constantPoolCount</code>, with the exception for constants of type
	 * <code>long</code> and
	 * <code>double</code> noted in <a class="xref"
	 * href="jvms-4.html#jvms-4.4.5" title="4.4.5.&nbsp;The CONSTANT_Long_info
	 * and CONSTANT_Double_info Structures">&sect;4.4.5</a>. </p>
	 *
	 * @return <code>constantPoolCount</code>
	 */
	public int getConstantPoolCount() {
		return constantPool.size();
	}

	public ConstantPool getConstantPool() {
		return constantPool;
	}

	public AccessFlags getAccessFlags() {
		return accessFlags;
	}

	public ConstantClass getThisClass() {
		return thisClass;
	}

	public ConstantClass getSuperClass() {
		return superClass;
	}

	/**
	 * <p><a name="jvms-4.1-200-H"></a>The value of the
	 * <code>interfacesCount</code> item gives the number of direct
	 * superinterfaces of this class or interface type. </p>
	 *
	 * @return <code>interfacesCount</code>
	 */
	public int getInterfacesCount() {
		return interfaces.length;
	}

	public ConstantClass[] getInterfaces() {
		return interfaces;
	}

	/**
	 * <p><a name="jvms-4.1-200-J"></a>The value of the
	 * <code>fieldsCount</code> item gives the number of
	 * <code>field_info</code> structures in the
	 * <code>fields</code> table. The
	 * <code>field_info</code> (<a class="xref" href="jvms-4.html#jvms-4.5"
	 * title="4.5.&nbsp;Fields">&sect;4.5</a>) structures represent all fields,
	 * both class variables and instance variables, declared by this class or
	 * interface type. </p>
	 */
	public int getFieldsCount() {
		return fields.length;
	}

	/**
	 * <p><a name="jvms-4.1-200-L"></a>The value of the
	 * <code>methodsCount</code> item gives the number of
	 * <code>method_info</code> structures in the
	 * <code>methods</code> table. </p>
	 */
	public int getMethodsCount() {
		return methods.length;
	}

	/**
	 * <p><a name="jvms-4.1-200-N"></a>The value of the
	 * <code>attributesCount</code> item gives the number of attributes (<a
	 * class="xref" href="jvms-4.html#jvms-4.7"
	 * title="4.7.&nbsp;Attributes">&sect;4.7</a>) in the
	 * <code>attributes</code> table of this class. </p>
	 */
	public int getAttributesCount() {
		return attributes.length;
	}

	@Override
	public String toString() {
		return "ClassFile{" + "minorVersion=" + minorVersion + ", majorVersion=" + majorVersion + ", constantPool=" + constantPool + ", accessFlags=" + Integer.toHexString(accessFlags.getMask()) + ", thisClass=" + thisClass + ", superClass=" + superClass + ", interfaces=" + Arrays.toString(interfaces) + ", fields=" + Arrays.toString(fields) + ", methods=" + Arrays.toString(methods) + ", attributes=" + Arrays.toString(attributes) + '}';
	}

//	@Override
//	public String toDumpString() {
//		final StringBuilder sb = new StringBuilder();
//		sb.append("major_version: ").append(majorVersion).append('\n');
//		sb.append("minor_version: ").append(minorVersion).append('\n');
//		sb.append("this_class: ").append(thisClass.toDumpString()).append('\n');
//		sb.append("super_class: ").append(superClass.toDumpString()).append('\n');
//		sb.append("interfaces: ");
//		if (interfaces.length == 0) {
//			sb.append("[none]" + '\n');
//		} else {
//			for (int i = 0; i < interfaces.length; i++) {
//				if (i != 0) {
//					sb.append(", ");
//				}
//				final ConstantClass iface = interfaces[i];
//				sb.append(iface.toDumpString());
//			}
//			sb.append('\n');
//		}
//		sb.append("access_flags: ").append(accessFlags).append('\n').append('\n');
//		sb.append("constant_pool: ");
//		{
//			final int m = constantPool.size();
//			if (m > 1) {
//				sb.append('\n');
//				int n = 0;
//				for (int i = 1; i < m; i++) {
//					final ConstantPoolEntry entry = constantPool.get(i, ConstantPoolEntry.class);
//					final String className = Util.constant(entry.getClass().getSimpleName());
//					final int nameLength = className.length();
//					if (nameLength > n) {
//						n = nameLength;
//					}
//					if (entry instanceof ConstantLongNumber) {
//						i++;
//					}
//				}
//				n++;
//				for (int i = 1; i < m; i++) {
//					final ConstantPoolEntry entry = constantPool.get(i, ConstantPoolEntry.class);
//					final String index = String.format("#%1$0" + Util.digits(m) + "d = ", i);
//					final String className = Util.constant(entry.getClass().getSimpleName());
//					final String dumpString = entry.toDumpString();
//					sb.append(' ').append(index).append(String.format("%1$-" + n + "s", className)).append(dumpString).append('\n');
//					if (entry instanceof ConstantLongNumber) {
//						i++;
//					}
//				}
//			} else {
//				sb.append("[none]" + '\n');
//			}
//			sb.append('\n');
//		}
//		sb.append("fields: ");
//		if (fields.length == 0) {
//			sb.append("[none]" + '\n');
//		} else {
//			sb.append('\n');
//			for (int i = 0; i < fields.length; i++) {
//				final Field field = fields[i];
//				sb.append(' ').append(field.toDumpString()).append('\n');
//			}
//		}
//		sb.append('\n');
//		sb.append("methods: ");
//		if (methods.length == 0) {
//			sb.append("[none]" + '\n');
//		} else {
//			sb.append('\n');
//			for (int i = 0; i < methods.length; i++) {
//				final Method method = methods[i];
//				sb.append(' ').append(method.toDumpString()).append('\n');
//			}
//		}
////        sb.append('\n');
//		return sb.toString();
//	}

	@Override
	public void dump(final int indent) {
		Util.indent(indent);
		System.out.println("majorVersion = " + majorVersion);
		Util.indent(indent);
		System.out.println("minorVersion = " + minorVersion);
		Util.indent(indent);
		System.out.print("thisClass = ");
		thisClass.dump(0);
		System.out.println();
		Util.indent(indent);
		System.out.print("superClass = ");
		superClass.dump(0);
		System.out.println();
		Util.indent(indent);
		System.out.print("interfaces: ");
		if (interfaces.length == 0) {
			System.out.println("[none]");
		} else {
			for (int i = 0; i < interfaces.length; i++) {
				if (i != 0) {
					System.out.print(", ");
				}
				final ConstantClass iface = interfaces[i];
				iface.dump(0);
			}
			System.out.println();
		}
		Util.indent(indent);
		System.out.println("accessFlags: " + accessFlags);
		Util.indent(indent);
		System.out.print("constant_pool: ");
		constantPool.dump(indent + 1);
		Util.indent(indent);
		System.out.print("fields: ");
		if (fields.length == 0) {
			System.out.println("[none]");
		} else {
			System.out.println();
			for (int i = 0; i < fields.length; i++) {
				final Field field = fields[i];
				field.dump(indent + 1);
			}
		}
		System.out.println();
		Util.indent(indent);
		System.out.print("methods: ");
		if (methods.length == 0) {
			System.out.println("[none]");
		} else {
			System.out.println();
			for (int i = 0; i < methods.length; i++) {
				final Method method = methods[i];
				method.dump(indent + 1);
			}
		}
		Util.indent(indent);
		System.out.print("attributes: ");
		if (attributes.length == 0) {
			System.out.println("[none]");
		} else {
			System.out.println();
			for (int i = 0; i < attributes.length; i++) {
				final Attribute attribute = attributes[i];
				attribute.dump(indent + 1);
			}
		}
	}
}