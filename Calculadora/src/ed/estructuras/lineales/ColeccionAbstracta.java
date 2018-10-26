package ed.estructuras.lineales;
import java.util.*;
public abstract class ColeccionAbstracta<E> implements Collection<E>{
	@Override
	public boolean contains(Object o){
		boolean boo = false;
		for(E e: this){
			if (e.equals(o)) boo = true;
		}
		return boo;
	}
	@Override
	public Object[] toArray(){
		int size=0;
		for(Object n : this){
	 		size++;
		}
		Object[] a= new Object[size];
		int i=0;
		for(Object n : this){
			a[i]=n;
			i++;
		}
		return a;
	}
	@Override
	public <T> T[] toArray(T[] a){
		int i=0;
		for(E t : this){
			a[i]=(T)t;
			i++;
		}
		return a;
	}
	@Override
	public boolean containsAll(Collection<?> c){
		if(c==null) throw new IllegalArgumentException("Pon una collection valida");
		boolean res = false;
		for(Object o : c){
			res = this.contains(o);
		}
		return res;
	}
	@Override	
	public boolean addAll(Collection<? extends E> c){
		boolean boo = false;		
		if(c==null) throw new IllegalArgumentException("Pon una collection valida");
		try{
			for(E o : c){
				this.add(o);
			}
		boo = true;
		}catch(Exception e){
			throw e;
		}
		return boo;
	}
	@Override
	public boolean remove(Object o){
		boolean boo = false;
		if(o==null) throw new IllegalArgumentException("Pon una collection valida");
		Iterator<E> it = this.iterator();
		while(it.hasNext()){
			if(o.equals(it.next())){
				it.remove();
				boo = true;
			}			
		}
		return boo;
	}
	@Override
	public boolean removeAll(Collection<?> c){
		boolean boo = false;
		if(c==null) throw new IllegalArgumentException("Pon una collection valida");
		for(Object o : c){
			for (E e : this){
				if(e.equals(o)){
					this.remove(e);
					boo = true;
				}
			}
		}
		return boo;
	}
	@Override
	public boolean retainAll(Collection<?> c){
		boolean boo = false;
		Iterator<E> it = this.iterator();
		while(it.hasNext()){
		Object o = it.next();
				if((c.contains(o))){
					System.out.println("C contiene a "+ String.valueOf(o) + ", guardalo");
				}else{
					it.remove();
				}
		}
		return boo;
	}
	@Override
	public void clear(){
		Iterator<E> it = this.iterator();
		while(it.hasNext()){	
			Object o = it.next();
			it.remove();
		}
	}
	
	@Override
	public String toString(){
		String c = "";
		for(Object n : this){
			c = c + " " + String.valueOf(n);
		}
		return c; 
	}



}	
