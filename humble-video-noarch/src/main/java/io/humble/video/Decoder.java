/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.humble.video;
import io.humble.ferry.*;
/**
 * Decodes MediaPacket objects into MediaAudio, MediaPicture or MediaSubtitle objects.
 */
public class Decoder extends Coder {
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  /**
   * This method is only here to use some references and remove
   * a Eclipse compiler warning.
   */
  @SuppressWarnings("unused")
  private void noop()
  {
    Buffer.make(null, 1);
  }
   
  private volatile long swigCPtr;

  /**
   * Internal Only.
   */
  protected Decoder(long cPtr, boolean cMemoryOwn) {
    super(VideoJNI.Decoder_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }
  
  /**
   * Internal Only.
   */
  protected Decoder(long cPtr, boolean cMemoryOwn,
      java.util.concurrent.atomic.AtomicLong ref)
  {
    super(VideoJNI.Decoder_SWIGUpcast(cPtr),
     cMemoryOwn, ref);
    swigCPtr = cPtr;
  }
    
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  protected static long getCPtr(Decoder obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */  
  protected long getMyCPtr() {
    if (swigCPtr == 0) throw new IllegalStateException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Create a new Decoder object that is actually referring to the
   * exact same underlying native object.
   *
   * @return the new Java object.
   */
  @Override
  public Decoder copyReference() {
    if (swigCPtr == 0)
      return null;
    else
      return new Decoder(swigCPtr, swigCMemOwn, getJavaRefCount());
  }

  /**
   * Compares two values, returning true if the underlying objects in native code are the same object.
   *
   * That means you can have two different Java objects, but when you do a comparison, you'll find out
   * they are the EXACT same object.
   *
   * @return True if the underlying native object is the same.  False otherwise.
   */
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof Decoder)
      equal = (((Decoder)obj).swigCPtr == this.swigCPtr);
    return equal;
  }
  
  /**
   * Get a hashable value for this object.
   *
   * @return the hashable value.
   */
  public int hashCode() {
     return (int)swigCPtr;
  }
  
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<
  // JNIHelper.swg: End generated code
  

/**
 * Create a Decoder that will use the given Codec.<br>
 * <br>
 * @return a Decoder<br>
 * @throws InvalidArgument if codec is null or codec cannot decode.
 */
  public static Decoder make(Codec codec) {
    long cPtr = VideoJNI.Decoder_make__SWIG_0(Codec.getCPtr(codec), codec);
    return (cPtr == 0) ? null : new Decoder(cPtr, false);
  }

/**
 * Creates a Decoder, copying parameters from a given Coder (either an encoder or a decoder).<br>
 * @return a Decoder<br>
 * @throws InvalidArgument if src is null
 */
  public static Decoder make(Coder src) {
    long cPtr = VideoJNI.Decoder_make__SWIG_1(Coder.getCPtr(src), src);
    return (cPtr == 0) ? null : new Decoder(cPtr, false);
  }

/**
 * Flush this Decoder, getting rid of any cached packets (call after seek).<br>
 * Next packet given to decode should be a key packet.
 */
  public void flush() {
    VideoJNI.Decoder_flush(swigCPtr, this);
  }

/**
 * Decode this packet into output.  It will<br>
 * try to fill up the audio samples object, starting<br>
 * from the byteOffset inside this packet.<br>
 * <p><br>
 * The caller is responsible for allocating the<br>
 * MediaAudio object.  This function will overwrite<br>
 * any data in the samples object.<br>
 * </p><br>
 * @param output The MediaAudio we decode to. Caller must check if it is complete on return.<br>
 * @param packet    The packet we're attempting to decode from.<br>
 * @param byteOffset Where in the packet payload to start decoding<br>
 * <br>
 * @return number of bytes actually processed from the packet, or negative for error
 */
  public int decodeAudio(MediaAudio output, MediaPacket packet, int byteOffset) {
    return VideoJNI.Decoder_decodeAudio(swigCPtr, this, MediaAudio.getCPtr(output), output, MediaPacket.getCPtr(packet), packet, byteOffset);
  }

/**
 * Decode this packet into output.<br>
 * <br>
 * The caller is responsible for allocating the<br>
 * MediaPicture object.  This function will potentially<br>
 * overwrite any data in the frame object, but<br>
 * you should pass the same MediaPicture into this function<br>
 * repeatedly until Media.isComplete() is true.<br>
 * <p><br>
 * Note on memory for MediaPicture: For a multitude of reasons,<br>
 * if you created MediaPicture from a buffer, decodeVideo will discard<br>
 * it and replace it with a buffer that is aligned correctly for different<br>
 * CPUs and different codecs. If you must have a copy of the image data<br>
 * in memory managed by you, then pass in a MediaPicture allocated without<br>
 * a buffer to DecodeVideo, and then copy that into your own media picture.<br>
 * </p><br>
 * <br>
 * @param output The MediaPicture we decode. Caller must check if it is complete on return.<br>
 * @param packet  The packet we're attempting to decode from.<br>
 * @param byteOffset Where in the packet payload to start decoding<br>
 * <br>
 * @return number of bytes actually processed from the packet, or negative for error
 */
  public int decodeVideo(MediaPicture output, MediaPacket packet, int byteOffset) {
    return VideoJNI.Decoder_decodeVideo(swigCPtr, this, MediaPicture.getCPtr(output), output, MediaPacket.getCPtr(packet), packet, byteOffset);
  }

/**
 * Decode this packet into output.  It will<br>
 * try to fill up the media object, starting<br>
 * from the byteOffset inside this packet.<br>
 * <p><br>
 * The caller is responsible for allocating the<br>
 * correct underlying Media object.  This function will overwrite<br>
 * any data in the samples object.<br>
 * </p><br>
 * @param output The Media we decode to. Caller must check if it is complete on return.<br>
 * @param packet    The packet we're attempting to decode from.<br>
 * @param byteOffset Where in the packet payload to start decoding<br>
 * <br>
 * @return number of bytes actually processed from the packet, or negative for error<br>
 * <br>
 * @throws InvalidArgument if the media type is not compatible with this decoder.<br>
 * @see decodeVideo<br>
 * @see decodeAudio
 */
  public int decode(MediaSampled output, MediaPacket packet, int byteOffset) {
    return VideoJNI.Decoder_decode(swigCPtr, this, MediaSampled.getCPtr(output), output, MediaPacket.getCPtr(packet), packet, byteOffset);
  }

}
